import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Packet } from '../_models/packet.model';
import { PacketService } from '../_services/packet.service';
import { TransactionService } from '../_services/transaction.service';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from '../_services/token-storage.service';


@Component({
  selector: 'app-info-pack',
  templateUrl: './info-pack.component.html',
  styleUrls: ['./info-pack.component.css']
})
export class InfoPackComponent implements OnInit {

  packetId!: string | null;
  packetInfo!: Packet;

  seller!: string;

  form: any = {
    buyerid: null,
    packetid: null,
    time: null
  };

  message!: string;

  current = new Date();

  constructor(private packetService: PacketService, private transactionService: TransactionService, private route: ActivatedRoute, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {

    if (this.tokenStorage.getToken()) {
      this.form.buyerid = this.tokenStorage.getUser().id;
    }

    this.packetId = this.route.snapshot.queryParamMap.get('packetId');
    console.log(this.packetId);

    this.findPacketbyID(this.packetId);

    this.form.packetid = this.packetId;
    //this.form.sellerid = this.seller;
    this.form.time = this.current.getTime();

  }

  onSubmit(): void {
    this.addTransaction(this.form);
  }

  //restituisce packetUp
  public findPacketbyID(packetId: string | null): any {
    this.packetService.findPacketbyID(packetId).subscribe(
      (response: any) => {
        this.packetInfo = response.packet;
        this.seller = response.packet.owner.id;
        console.log(response.packet);  //metto response.packet in modo che in console mi mandi solo il pacchetto
      }
      //commentando questo non mi esce sempre ERROR 404 ogni volta che cerco di fare la ricerca
      ,
      (error: HttpErrorResponse) => {
        //alert(error.message);
      }

    );
  }


  public addTransaction(form: NgForm): void {

    const { buyerid, packetid, time } = this.form;

    this.transactionService.addTransaction(buyerid, packetid, this.seller, time).subscribe(
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
