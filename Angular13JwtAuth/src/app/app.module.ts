import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { SearchComponent } from './search/search.component';
import { TransactionOKComponent } from './transaction-ok/transaction-ok.component';
import { TransactionKOComponent } from './transaction-ko/transaction-ko.component';
import { SettingsComponent } from './settings/settings.component';
import { CreatePackComponent } from './create-pack/create-pack.component';
import { InfoPackComponent } from './info-pack/info-pack.component';
import { PacketComponent } from './packet/packet.component';
import { UpdatePacketComponent } from './update-packet/update-packet.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { TopupComponent } from './topup/topup.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    SearchComponent,
    TransactionOKComponent,
    TransactionKOComponent,
    SettingsComponent,
    CreatePackComponent,
    InfoPackComponent,
    PacketComponent,
    UpdatePacketComponent,
    DeleteUserComponent,
    TopupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
