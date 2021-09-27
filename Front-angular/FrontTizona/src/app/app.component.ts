import { Component } from '@angular/core';
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { environment } from 'src/environments/environment';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styles: [],
})
export class AppComponent {
  app = initializeApp(environment.firebaseConfig);
  analytics = getAnalytics(this.app);
  title = environment.title;
}
