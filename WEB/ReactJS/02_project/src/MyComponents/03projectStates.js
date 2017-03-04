import React, { Component } from 'react';

class ProjectState extends Component{
    deleteState(id){    // (this,...) this does not need to be announced 
        console.log('send delete to project.js');
        this.props.onDelete(id);
    }

    render(){
        return(
        // this.props.key is not a prop, props = with keys HTML doesn't use
            // key word is already saved by HTML on li items 
            <li className="ProjectState">
                {this.props.state.title} :: 
                 {this.props.state.category} <br />
                 id : {this.props.state.id} <br />
                 <a href="#" onClick={this.deleteState.bind(
                     this,this.props.state.id
                     )}>X</a>
            </li>
        );
    }
}

ProjectState.propTypes = {
    // key: React.PropTypes.string, NOT a prop, a saved HTML key value
    state: React.PropTypes.object,
    onDelete: React.PropTypes.func
}

export default ProjectState;