import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent }  from './app.component';
import { MainComponent } from './MyComponents/main.component';
import { HttpModule } from '@angular/http';
import { RoutingComponent } from './MyRouting/routing.component';
import { routing } from './app.routing';

@NgModule({
  imports:      [ BrowserModule , HttpModule , routing , FormsModule ],
  declarations: [ AppComponent , MainComponent , RoutingComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }

// imports : for Angular services
// declarations : for components
