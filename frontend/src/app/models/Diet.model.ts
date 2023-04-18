import {Triplet} from '../models/Triplet.model'

export interface Diet {
  id?: number;
  name: String;
  description: String;
  week: Triplet[];
  dietRefactored: String[7];
}
