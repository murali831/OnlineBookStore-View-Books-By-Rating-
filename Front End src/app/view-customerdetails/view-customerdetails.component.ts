import { Component, OnInit } from '@angular/core';
import { CustomerInformation } from '../customer-information';
import { UpdateuserprofileserviceService } from '../updateuserprofileservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customerdetails',
  templateUrl: './view-customerdetails.component.html',
  styleUrls: ['./view-customerdetails.component.css']
})
export class ViewCustomerdetailsComponent implements OnInit {

  customerinformation:CustomerInformation=null;
  email:string;
  msg:string;
  constructor(private customerser:UpdateuserprofileserviceService,private router: Router) { }

  ngOnInit() {
  }
  searchById(){
    this.customerser.viewcustomer(this.email).subscribe(data=>{this.customerinformation=data,
      this.customerser.customer=this.customerinformation;
      this.msg=undefined},
      error=>{console.log(error);this.msg=error.error.message; this.customerinformation=null});
  }
  gotoupdate(page:string){
      this.router.navigateByUrl("/updatecustomer")
    }
}
