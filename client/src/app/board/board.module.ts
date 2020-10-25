import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BoardListComponent } from './board-list/board-list.component';
import { BoardEditComponent } from './board-edit/board-edit.component';
import { BoardService } from './board.service';
import { BOARD_ROUTES } from './board.routes';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild(BOARD_ROUTES)
  ],
  declarations: [
    BoardListComponent,
    BoardEditComponent
  ],
  providers: [BoardService],
  exports: []
})
export class BoardModule { }
