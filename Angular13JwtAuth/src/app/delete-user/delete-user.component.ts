import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { User } from '../_models/user.model';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})


export class DeleteUserComponent implements OnInit {

  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.deleteUser(this.tokenStorage.getUser().id);
  }

  public deleteUser(userId: string): void {

    this.userService.deleteUser(userId).subscribe(
      (response: void) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

}
