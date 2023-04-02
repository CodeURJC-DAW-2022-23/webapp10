export interface Recipe {
  id?: number;
  name: string;
  surname: string;
  email: string;
  description: string;
  userType: string;
  encodedPassword: string;
  diet: Diet;
  form: Form;
  imageFile: string;
  image: Blob;
  entryDate: number;
}
