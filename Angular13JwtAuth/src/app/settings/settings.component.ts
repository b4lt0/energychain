
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../_models/user.model';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  id!: string;
  name!: string;
  email!: string;
  //business: string;

  userUp!: User;


  message!: string;

  form: any = {
    username: null,
    password: null
  };

  errorMessage = '';

  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {

    if (this.tokenStorage.getToken()) {
      this.id = this.tokenStorage.getUser().id;
      this.name = this.tokenStorage.getUser().username;
      this.email = this.tokenStorage.getUser().email;
    }

  }

  onSubmit(): void {
    this.updateUser(this.form);
  }

  public updateUser(form: NgForm): void {

    const { username, password } = this.form;

    this.userService.updateUser(this.id, username, password).subscribe(
      (response: any) => {
        console.log(response);
        this.message = response.result.msg;
        alert(this.message);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

 
  }

