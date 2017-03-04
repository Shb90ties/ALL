import React, { Component } from 'react';
import uuid from 'uuid';

class AddState extends Component{
        // making an array for the render
            // static defaultProps can be accessed from props
    static defaultProps = {
        categoris : ['Web Design','Web Development','Web Something']
    }

    constructor(){
        super();
        this.state = {
            newState : {}
        }   // gets values on setState newState
    }

    mySubmit(args){
        console.log('Submitted!! ' + this.refs.title.value);
        if( this.refs.title.value === '' ){ 
            alert('no values');
         }else{
             this.setState({ newState:{
                id : uuid.v4(),
                title : this.refs.title.value,
                category : this.refs.category.value
             }
            }, function(){
                console.log(this.state);
                this.props.addState(this.state.newState);
                    // ^ function/callback passed from App.js
            });         // * the newState is saved in this.state
         }                  // look at constructor
        args.preventDefault();
        // stops the from submitting, page won't reload
    }

    render(){
        let categoriesOptions = this.props.categoris.map(
            category => {
                return <option key={category} name="category"
                        value={category}> {category} </option>
            }
        );
    // use ref=".." to get values on form submit
        return (
            <div>
                <h3>Add State!!</h3>
                <form onSubmit={this.mySubmit.bind(this)}>
                    Title : 
                    <input type="text" ref="title" /><br />
                    <select ref="category">
                        {categoriesOptions}
                    </select>
                    <input type="submit" value="Add"/>
                </form>
            </div>
        );
    }
}

AddState.propTypes = {
    addState: React.PropTypes.func
}


export default AddState;