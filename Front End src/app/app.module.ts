import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { MostFavoredBooksComponent } from './most-favored-books/most-favored-books.component';
import { BestSellingBooksComponent } from './best-selling-books/best-selling-books.component';
import { RecentPublishedBooksComponent } from './recent-published-books/recent-published-books.component';
import { ProductComponent } from './product/product.component';
import { ViewCustomerdetailsComponent } from './view-customerdetails/view-customerdetails.component';
import { UpdateUserProfileComponent } from './update-user-profile/update-user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MostFavoredBooksComponent,
    BestSellingBooksComponent,
    RecentPublishedBooksComponent,
    ProductComponent,
    ViewCustomerdetailsComponent,
    UpdateUserProfileComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
