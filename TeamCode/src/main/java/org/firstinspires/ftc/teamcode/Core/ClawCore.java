package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawCore {
    // Init vars
    private Servo leftClaw = null;
    private Servo rightClaw = null;
    private boolean clawIsOpen = false; //stores the initial state of the claw.

    public void init (HardwareMap hardwareMap){
        // Mapping claw servos to vars
        leftClaw = hardwareMap.get(Servo.class, "claw_left");
        rightClaw = hardwareMap.get(Servo.class, "claw_right");
    }

    /** telemetry
     *  main function for outputting variable information to debug later
     */
    public void telemetry(Telemetry tem){
        tem.addData("Claw Left POS:", leftClaw.getPosition());
        tem.addData("Claw Right POS:", rightClaw.getPosition());
    }


    /** clawToggle
     *  sets the claw to be in either open or closed position.
     *  the state of the claw is stored as a private field within the object instance. This ensures
     *  that the claw will still open and close even if it has been bumped or stressed to a different point.
     */
    public void clawToggle(){
        // same function as an if/else statement: IF clawIsOpen THEN clawClose() ELSE clawOpen()
        (clawIsOpen) ? clawClose() : clawOpen();
    }


    /** clawOpen
     *  Opens the claw to a pre-set width.
     */
    public void clawOpen(){
        leftClaw.setPosition(0.3);
        rightClaw.setPosition(0.6);
        clawIsOpen = true;
    }

    /** clawClose
     *  closes the claw to a pre-set width.
     */
    public void clawClose(){
        leftClaw.setPosition(0.6);
        rightClaw.setPosition(0.2);
        clawIsOpen = false;
    }
}
