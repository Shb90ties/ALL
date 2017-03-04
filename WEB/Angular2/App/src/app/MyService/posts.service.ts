import { Injectable } from '@angular/core';
    // being able to inject this service as a dependandcy
        // providers = [...,serviceName]
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
    // used for converting res to => jason

@Injectable()
export class PostGetService{
    constructor(private http: Http){
                // ^ creates an object and with it you will send and get requests
        console.log('Post GET Service is running');
    }

    GetPosts(){
        return this.http
                .get('https://jsonplaceholder.typicode.com/posts')
                    .map(res => res.json());
                        // converts the result to JSON using the map that we imported
    }
}