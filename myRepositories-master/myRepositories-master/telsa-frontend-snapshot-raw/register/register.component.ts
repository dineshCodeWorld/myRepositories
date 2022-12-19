import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { UserDto } from '../user-dto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder,private router:Router) { }
  userDto!:FormGroup;
  response!:string;

  ngOnInit(): void
   {
     this.userDto = this.fb.group({
                     firstName:['',[Validators.required,Validators.pattern("[A-Za-z]{2,15}")]],
                     lastName:['',[Validators.required,Validators.pattern("[A-Za-z]{2,15}")]],
                     email:['',[Validators.required,Validators.email]],
                     password:['',[Validators.required,Validators.pattern("([A-Za-z0-9@.$=]{5,15})")]]
   })
   }

  public register()
  {
    this.service.registration(this.userDto.value).subscribe(response=>this.response=response);
  }

  public resendToken()
  {
    this.router.navigate(['/resend-token']);
  }

  public changePassword()
  {
    this.router.navigate(['/change-password']);
  }

  public resetPassword()
  {
     this.router.navigate(['/forgot-password']);
  }

  public getUserList()
  {
    this.router.navigate(['/user-list']);
  }

  public deleteUser()
  {
    this.router.navigate(['/delete-user']);
  }

  public updateProfile()
  {
    this.router.navigate(['/update-profile']);
  }

  public changeRole()
  {
    this.router.navigate(['/change-role']);
  }

}
