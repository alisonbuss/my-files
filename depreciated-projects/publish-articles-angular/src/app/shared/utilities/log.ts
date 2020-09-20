
import { Injectable } from '@angular/core';

import { LogInterface } from "./log.interface";

@Injectable({
  providedIn: 'root'
})
export class Log implements LogInterface {

    constructor() {}

    public debug(message: string, ...dataDetails: any[]): void {
        this.emitLogMessage("debug", message, dataDetails);
    }

    public warn(message: string, ...dataDetails: any[]): void {
        this.emitLogMessage("warn", message, dataDetails);
    }

    public error(message: string, ...dataDetails: any[]): void {
        this.emitLogMessage("error", message, dataDetails);
    }

    public info(message: string, ...dataDetails: any[]): void {
        this.emitLogMessage("info", message, dataDetails);
    }

    private emitLogMessage(type: "debug"|"warn"|"error"|"info", msg: string, details: any[]): void {
        if(details.length > 0) {
            console[type](msg, details);
        } else {
            console[type](msg);
        }
    }

}
