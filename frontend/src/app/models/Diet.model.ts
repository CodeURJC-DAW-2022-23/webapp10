import {Triplet} from '../models/Triplet.model'

export interface Diet {
  id?: number;
  name: String;
  type: String;
  week: Triplet[];
  dietRefactored: String[][];
}
