import { Component } from '@angular/core';
import { PostGetService } from '../MyService/posts.service';

@Component({
    moduleId: module.id,
    selector: 'main-component',
    templateUrl: 'main.component.html',
    providers: [PostGetService]
})
export class MainComponent{
    myTitle: string;
    myID: Number;
    MyPosts: post[];
    myI: Number;

    constructor(private postGETservice: PostGetService){
        console.log('running!!');
        this.myTitle = 'main component!!';
        this.myID = 44;
        this.myI = -1;

        this.postGETservice.GetPosts().subscribe(posts => {
            this.MyPosts = posts;
        });
        // ^ short cut for
        // posts = post[];
        // posts = this.postGETservice.GetPosts().subscribe();
        // this.MyPosts = posts;
    }

    changePostID(i:string)
    {
        this.myI = parseInt(i);
        console.log(this.myI);
    }
}

interface post{
    title: string;
    body: string;
    id: Number;
}   // matches the JSON structure of the post request
