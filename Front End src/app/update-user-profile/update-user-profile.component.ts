import { Component, OnInit } from '@angular/core';
import { UpdateuserprofileserviceService } from '../updateuserprofileservice.service';
import { Router } from '@angular/router';
import { CustomerInformation } from '../customer-information';



@Component({
  selector: 'app-update-user-profile',
  templateUrl: './update-user-profile.component.html',
  styleUrls: ['./update-user-profile.component.css']
})
export class UpdateUserProfileComponent implements OnInit {

  constructor(private eser:UpdateuserprofileserviceService,private router: Router) { }
  errormsg:string;
   updatedcustomer:CustomerInformation;
  customerinfo:CustomerInformation=this.eser.customer;
  message:string;
  confirmpassword:boolean;
  cpassword:string;
  newpassord:string;
  ngOnInit(): void {
    this.customerinfo=this.eser.customer;
  
  }
  updatecustomerprofile(){
  
  if(this.cpassword===this.newpassord)
  {
    if(this.newpassord!=undefined)
    this.customerinfo.password=this.newpassord;
    this.eser.updatecustomerinfo(this.customerinfo).subscribe(data=>
      {
      this.message=data;
      this.eser.getcustomerinfo(this.customerinfo.customerId).subscribe(data=>
        {
          this.updatedcustomer=data;
          console.log(this.updatedcustomer);
         
        
    })},
      error=>
      {
        console.log("error occured",error);
        this.errormsg=JSON.parse(error.error).message;
        console.log(error);
      }
    );
    }
    else{
      console.log("Not called");
    }
  }
}
