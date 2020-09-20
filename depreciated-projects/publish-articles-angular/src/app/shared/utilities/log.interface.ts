
// @fonts: https://blog.hellojs.org/simple-javascript-logger-in-typescript-demonstrating-interfaces-union-types-and-rest-parameters-6efc5aee2c97

export interface LogInterface {

    debug(message: string, ...data: any[]): void;

    warn(message: string, ...data: any[]): void;

    error(message: string, ...data: any[]): void;

    info(message: string, ...data: any[]): void;

}
