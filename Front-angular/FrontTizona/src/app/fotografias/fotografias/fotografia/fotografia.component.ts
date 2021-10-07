import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Fotografia } from '../../models/fotografia';
import { FotografiasService } from '../../service/fotografias.service';

@Component({
  selector: 'app-fotografia',
  templateUrl: './fotografia.component.html',
  styles: []
})
export class FotografiaComponent implements OnInit {
  @Input () fotografia: Fotografia;
  @Input () id: number;
  urlTrusted: SafeUrl;
  @Output() deleteImageEvent = new EventEmitter<Fotografia>();
  

  constructor(private fotografiasService: FotografiasService, private sanitizer: DomSanitizer) { 
  }

  ngOnInit() {
    this.urlTrusted = this.sanitizer.bypassSecurityTrustUrl(this.fotografia.url);

  }
  eliminarFotografia(): void {
    
    this.deleteImageEvent.emit(this.fotografia);
    
  }

}
