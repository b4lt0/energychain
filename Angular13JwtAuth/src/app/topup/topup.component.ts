
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../_models/user.model';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-topup',
  templateUrl: './topup.component.html',
  styleUrls: ['./topup.component.css']
})
export class TopupComponent implements OnInit {

  form: any = {
    money: null,
    operation: null
  };

  errorMessage!: string;
  id!: string;

  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.id = this.tokenStorage.getUser().id;
    }
  }

  onSubmit(): void {
    const { money, operation } = this.form;

    this.userService.depositMoney(this.id ,money, operation).subscribe({
      next: (data:any) => {
        console.log(data);
        alert("Operation completed!");
        alert(data.result.msg)
      },
      error: err => {
        alert("Operation failed!");
      }
    });
  }

}
