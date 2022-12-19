import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserDto } from './user-dto';
import { Observable } from 'rxjs';
import { PasswordDto } from './password-dto';
import { UserList } from './user-list';
import { UpdateDto } from './update-dto';
import { ChangeRoleDto } from './change-role-dto';

@Injectable({
  providedIn: 'root'
})
export class ServicesService
 {

  constructor(private http:HttpClient) { }

  public registration(userDto:UserDto):Observable<any>
  {
     return this.http.post("http://127.0.0.1:8080/register",userDto,{responseType:'text' as 'json'});
  }

  public resendToken(userDto:UserDto):Observable<any>
  {
     return this.http.post("http://127.0.0.1:8080/resendToken",userDto,{responseType:'text' as 'json'});
  }

  public changePassword(passwordDto:PasswordDto):Observable<any>
  {
     return this.http.post("http://127.0.0.1:8080/changePassword",passwordDto,{responseType:'text' as 'json'});
  }

  public resetPassword(passwordDto:PasswordDto):Observable<any>
  {
     return this.http.post("http://127.0.0.1:8080/resetPassword",passwordDto,{responseType:'text' as 'json'});
  }

  public getUserList():Observable<UserList[]>
  {
   return this.http.get<UserList[]>("http://127.0.0.1:8080/getUserList");
  }

  public deletUser(userDto:UserDto):Observable<any>
  {
     return this.http.post("http://127.0.0.1:8080/deleteUser",userDto,{responseType:'text' as 'json'});
  }

  public updateProfile(updateDto:UpdateDto):Observable<any>
  {
     return this.http.put("http://127.0.0.1:8080/updateProfile",updateDto,{responseType:'text' as 'json'});
  }

  public changeRole(changeRole:ChangeRoleDto):Observable<any>
  {
     return this.http.post("http://127.0.0.1:8080/changeUserRole",changeRole,{responseType:'text' as 'json'});
  }
}
