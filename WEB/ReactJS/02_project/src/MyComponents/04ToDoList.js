import React, { Component } from 'react';

class ToDoList extends Component{

    render(){
        let toDoList;
        if(this.props.DoList){
            toDoList = this.props.DoList.map(toDo =>{
                return (
                    <li>
                        <strong>{toDo.title} | </strong>
                        status : {toDo.completed.toString()}
                    </li>
                );
            });
        }

        return (
            <div className="ToDoList">
                <h3>ToDo List from API </h3>
                <ul>{toDoList}</ul>
            </div>
        );
    }
}

ToDoList.propTypes = {
    DoList: React.PropTypes.array
}

export default ToDoList;