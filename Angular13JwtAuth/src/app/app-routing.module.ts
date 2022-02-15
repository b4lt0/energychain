import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { SearchComponent } from './search/search.component';
import { SettingsComponent } from './settings/settings.component';
import { CreatePackComponent } from './create-pack/create-pack.component';
import { PacketComponent } from './packet/packet.component';
import { InfoPackComponent } from './info-pack/info-pack.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { UpdatePacketComponent } from './update-packet/update-packet.component';
import { TopupComponent } from './topup/topup.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'settings', component: SettingsComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'create', component: CreatePackComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'search', component: SearchComponent },
  { path: 'packet', component: PacketComponent },
  { path: 'info', component: InfoPackComponent },
  { path: 'delete', component: DeleteUserComponent },
  { path: 'edit', component: UpdatePacketComponent },
  { path: 'topup', component: TopupComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
