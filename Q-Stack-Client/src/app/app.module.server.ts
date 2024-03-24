import { NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';
import { AppModule } from './app.module';
import { AppComponent } from './app.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';


@NgModule({
  imports: [
    AppModule,
    ServerModule,
    MatSlideToggleModule,
  ],
  bootstrap: [AppComponent],
})
export class AppServerModule {}
