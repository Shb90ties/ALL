import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MainComponent } from './MyComponents/main.component';
import { RoutingComponent } from './MyRouting/routing.component';

const MyPathRoutes: Routes = [
    {
        path: '',
        component: MainComponent
    },
    {
        path: 'route', // will use this component on localhost:3000/route
        component: RoutingComponent
    }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(MyPathRoutes);