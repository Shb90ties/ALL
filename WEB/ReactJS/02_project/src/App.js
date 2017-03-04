import React, { Component } from 'react';
import './App.css';
import Project from './MyComponents/01project';
import AddState from './MyComponents/02addState'; 
// npm install --save uuid : id generator
import uuid from 'uuid';
// npm install --save jquery
import $ from 'jquery';
    // want to use $ to call jQuery
import ToDoList from './MyComponents/04ToDoList';

class App extends Component {
// React is about stats, define stats in constructor
  constructor(){
    super(); // must have super();
    this.state = { 
      projects: [],
      todos : [] }
  }     // ^ goes to componentWillMount automatically

  componentWillMount(){
    // for add-remove states(JSON objs)
      // from addState.js,project.js,projectStates.js
    this.getStates();
    // for API todo list from fakeJSON API
    this.getToDos();
  }

  getStates(){
    this.setState({ projects: [
          {   // ^ setState will show changes on browser
            id: uuid.v4(),
            title: 'PC website',
            category: 'Web Design'
          },
          {
            id: uuid.v4(),
            title: 'Mobile website',
            category: 'Web Design'
          }
    ]});
  }

  InsertAstate(state){
    console.log('App.js recieved the ' + state + ' from addState.js');
    let states_ = this.state.projects;
    states_.push(state);
    this.setState({ projects: states_ });
  } // take old array push and set it as new array
      // to see changes on browser MUST USE setState

  DeleteAstate(id){
    console.log('projectState.js => project.js => deleting a state : '+id);
    let projects = this.state.projects;
    let deleteIndex = projects.findIndex(x => x.id === id);
    projects.splice(deleteIndex,1);
    this.setState({ projects : projects });
  }

  // API________ componentDidMount saved func by React
  componentDidMount(){
    this.getToDos();
  }

  getToDos(){
    console.log('here');
    $.ajax({
      url: 'https://jsonplaceholder.typicode.com/todos',
      dataType: 'json',
      cache: false,
      success: function(data){
        this.setState({ todos: data },function(){
                // function can be seperate  ^ optional 
          console.log('recieved from API : ');
          console.log(this.state.todos);
        }); 
          // must bind to use 'this'
      }.bind(this),
      error: function(xhr,status,err){
        console.log('error in ajax Request '+err);
      }
    });
  }
  // ___________________________



  render() {
// className, required in JSX
    return (
      <div className="App">
        My App!!! className="App" body
        <hr/>
        parent = className="App" <br />
        <AddState addState={this.InsertAstate.bind(this)}/>
        <hr/>
        parent = className="App" <br /><br />
        <Project onDelete={this.DeleteAstate.bind(this)} 
          MyStates={this.state.projects}/>
        <hr />
        <ToDoList DoList={this.state.todos} />
      </div>
    );
  } // main idea is to pass the states to main child
}

export default App;
  // to be usable in other files