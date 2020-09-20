
export class User {

    private _id: number;
    public firstName: string;
    public lastName: string;
    public sex: string;
    public email: string;
    public password: string;
    public token: string = "";

    constructor() {
        console.log("User -> constructor");
    }

    public get id(): number {
        return this._id;
    }

    public set id(_id: number) {
        this._id = _id;
    }

}