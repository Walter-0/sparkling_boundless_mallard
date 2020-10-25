import { Routes } from '@angular/router';
import { BoardListComponent } from './board-list/board-list.component';
import { BoardEditComponent } from './board-edit/board-edit.component';

export const BOARD_ROUTES: Routes = [
  {
    path: 'boards',
    component: BoardListComponent
  },
  {
    path: 'boards/:id',
    component: BoardEditComponent
  }
];
