import {Diet} from '../models/Diet.model'
import {Form} from './Formulary.model'

export interface User {
  id?: number;
  name: string;
  surname: string;
  email: string;
  description: string;
  userType: string;
  encodedPassword: string;
  diet: Diet;
  form:Form;
  imageFile:string;
  image:Blob;
  entryDate:number;
}
