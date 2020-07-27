import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { ViewCustomerdetailsComponent } from './view-customerdetails/view-customerdetails.component';
import { UpdateUserProfileComponent } from './update-user-profile/update-user-profile.component';

const routes: Routes = [
  {path:'home', component:HomeComponent},
  { path: 'product/:bookId', component: ProductComponent },
  {path:'viewcustomer',component:ViewCustomerdetailsComponent},
  {path:'updatecustomer',component:UpdateUserProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
