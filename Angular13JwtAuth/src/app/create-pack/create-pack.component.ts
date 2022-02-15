import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Packet } from '../_models/packet.model';
import { AuthService } from '../_services/auth.service';
import { PacketService } from '../_services/packet.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-create-pack',
  templateUrl: './create-pack.component.html',
  styleUrls: ['./create-pack.component.css']
})
export class CreatePackComponent implements OnInit {

  form: any = {
    title: null,
    description: null,
    quantity: null,
    price: null,
    type: null
  };

  //packetid: string= '1234';

  owner!: string;

  message!: string;
  errorMessage = '';

  constructor(private packetService: PacketService,private userService: UserService, private authService: AuthService, private tokenStorage: TokenStorageService) { }


  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.owner = this.tokenStorage.getUser().id;
    }
  }

  onSubmit(): void {
    
    this.addPacket(this.form);
  }

  public addPacket(form: NgForm): void {

    const { title, description, quantity, price, type } = this.form;

    this.packetService.addPacket(title, description, quantity, price, type, this.owner).subscribe(
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
/*
onSubmit(): void {
  const { username, email, password } = this.form;

  this.authService.register(username, email, password).subscribe({
    next: data => {
      console.log(data);
      this.isSuccessful = true;
      this.isSignUpFailed = false;
    },
    error: err => {
      this.errorMessage = err.error.message;
      this.isSignUpFailed = true;
    }
  });
}
*/
