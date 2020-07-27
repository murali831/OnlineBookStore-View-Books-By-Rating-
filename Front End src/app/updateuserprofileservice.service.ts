import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CustomerInformation } from './customer-information';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateuserprofileserviceService {

  constructor(private http:HttpClient) { }
  customer:CustomerInformation;
  customerid:number;
  showcustomerinfo:boolean;
  getcustomerinfo(customerid:number):Observable<any>
  {
    return this.http.get("http://localhost:8082/api/updateprofile/"+customerid);
  }
  updatecustomerinfo(customer:CustomerInformation):Observable<any>
  {
    this.customerid=customer.customerId;
    return this.http.put("http://localhost:8082/api/updateprofile/update/"+this.customerid+"/",customer,{responseType:'text'});
  }
  public viewcustomer(email:string):Observable<any> {
    return this.http.get("http://localhost:8082/api/viewByEmail/"+email);
   
  }
}
