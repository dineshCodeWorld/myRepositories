import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-resend-token',
  templateUrl: './resend-token.component.html',
  styleUrls: ['./resend-token.component.css']
})
export class ResendTokenComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder) { }
  userDto!:FormGroup;
  response!:string;

  ngOnInit(): void
  {
    this.userDto = this.fb.group({
                    email:['',[Validators.required,Validators.email]],
                    password:['',[Validators.required,Validators.pattern("([A-Za-z0-9@.$=]{5,15})")]]
  })
  }

  public resendToken()
  {
     this.service.resendToken(this.userDto.value).subscribe(response=>this.response=response);
  }
}
