package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawCore {
    private Servo rightClaw = null;
    private Servo leftClaw = null;
    private boolean clawIsOpen = false; //stores the initial state of the claw.
    public ClawCore (HardwareMap hardwareMap){
        rightClaw = hardwareMap.get(Servo.class, "claw_left");
        leftClaw = hardwareMap.get(Servo.class, "claw_right");
    }

    public void telemetry(Telemetry tem){
        tem.addData("Claw Left POS:", rightClaw.getPosition());
        tem.addData("Claw Right POS:", leftClaw.getPosition());
    }


    /** clawToggle
     *  sets the claw to be in either open or closed position.
     *  the state of the claw is stored as a private field within the object instance. This ensures
     *  that the claw will still open and close even if it has been bumped or stressed to a different point.
     */
    public void clawToggle(){
        if (clawIsOpen){
            clawClose();
        } else {
            clawOpen();
        }
    }


    /** clawOpen
     *  Opens the claw to a pre-set width.
     */
    public void clawOpen(){
        rightClaw.setPosition(0.9);
        //leftClaw.setPosition(0.6);
        clawIsOpen = true;
    }

    /** clawClose
     *  closes the claw to a pre-set width.
     */
    public void clawClose(){
        rightClaw.setPosition(0.2);
        //leftClaw.setPosition(0.2);
        clawIsOpen = false;
    }
}
