import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../_models/user.model';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public editUser!: User;

  
  wallet!: number;
  form: any = {
    money: null,
    operation: null
  };

  id!: string;
  username!: string;
  password!: string;

  errorMessage = '';

  constructor(private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.id = this.tokenStorage.getUser().id;
    }
    this.findUserbyID(this.id);
    
  }

  onSubmit(): void {
    
  }

  public findUserbyID(userId:string): any {

    this.userService.findUser(userId).subscribe(
      (response: any) => {
        console.log(response);
        this.wallet = response.wallet;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  /*
   *
   public findPacketbyID(packetId: string): any{
    this.packetService.findPacketbyID(packetId).subscribe(
      (response: any) => {
        this.packetFound = response.packet;
        this.search = true;
        console.log(response.packet);  //metto response.packet in modo che in console mi mandi solo il pacchetto
      }

       //commentando questo non mi esce sempre ERROR 404 ogni volta che cerco di fare la ricerca
      ,
      (error: HttpErrorResponse) => {
        //alert(error.message);
        this.search = false;
      }
    );
  }


  public updateUser(form: NgForm): void {

    const { username, password } = this.form;

    this.userService.updateUser(this.id, username, password).subscribe(
      (response: void) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  */

  

  /*

  public onOpenModal(user: User, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    
    if (mode === 'edit') {
      this.editUser = user;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    
    container!.appendChild(button);
    button.click();
  }*/

}
