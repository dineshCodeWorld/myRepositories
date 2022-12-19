import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder) { }

  userDto!:FormGroup;
  response!:string;

  ngOnInit(): void
   {
     this.userDto = this.fb.group({
                     email:['',[Validators.required,Validators.email]],
                     oldPassword:['',[Validators.required,Validators.pattern("([A-Za-z0-9@.$=]{5,15})")]],
                     newPassword:['',[Validators.required,Validators.pattern("([A-Za-z0-9@.$=]{5,15})")]]
   })
   }

  public changePassword()
  {
     this.service.changePassword(this.userDto.value).subscribe(response=>this.response=response);
  }

}
