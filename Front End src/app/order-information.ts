import { CustomerInformation } from './customer-information';
import { CartInformation } from './cart-information';

export class OrderInformation {
    orderId:number;
    recipientName:string;
    recipientPhoneNumber:string;
    streetAddress:string;
    city:string;
    zipCode:number;
    country:string;
    shippingAddress:string;
    quantity:number;
    totalPrice:number;
    orderStatus:string;
    paymentMethod:string;
    orderDate:Date;
    cart:Array<CartInformation>=new Array<CartInformation>();
    customer:CustomerInformation=new CustomerInformation();
}
