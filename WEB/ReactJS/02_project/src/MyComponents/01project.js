import React, { Component } from 'react';
import ProjectState from './03projectStates';

class Project extends Component{
    deleteState(id){
        console.log('passing the call from project.js to app.js');
        this.props.onDelete(id);
    }       // gets the id from projectState.js call

    render(){
        let pStates;    // let~var for the array passed from App.js
        if(this.props.MyStates){ // if not null
            pStates = this.props.MyStates.map(stateI =>{
                console.log('state : '+stateI);
                let key = 55;
                return (
                    <ProjectState key={stateI.id} 
                        onDelete={this.deleteState.bind(this)} 
                            state={stateI} />
                );
            });
        }
        // creates an array with projectState element for each
            // state that was passed from App.js
        return (
            <div className="Project">
                My Project className="Project" <br/>
                passed States from Appjs in console<br/>
                Array of projectState.js : <br/>
                <ul>{pStates}</ul>
            </div>
        );
    }
}

// THIS IS OPTIONAL
    // Define the propTypes that this component can recieve
Project.propTypes = {
    MyStates: React.PropTypes.array,
    onDelete: React.PropTypes.func
}                   // ^ not propTypes

export default Project;
        // to be usable in other files