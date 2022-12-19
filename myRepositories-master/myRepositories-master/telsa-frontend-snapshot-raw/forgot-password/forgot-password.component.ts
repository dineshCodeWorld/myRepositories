import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder) { }

  userDto!:FormGroup;
  response!:string;


  ngOnInit(): void
   {
     this.userDto = this.fb.group({
                     email:['',[Validators.required,Validators.email]],
                     newPassword:['',[Validators.required,Validators.pattern("([A-Za-z0-9@.$=]{5,15})")]]

   })
   }

  public resetPassword()
  {
    this.service.resetPassword(this.userDto.value).subscribe(response=>this.response=response);
  }

}
