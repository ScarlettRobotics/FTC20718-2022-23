package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawCore {
    // Initialize claw variables
    private Servo rightClaw = null;
    private Servo leftClaw = null;
<<<<<<< HEAD
    private boolean clawIsOpen = false; //stores the initial state of the claw.

    public ClawCore(HardwareMap hardwareMap) {
=======
    // Stores state of the claw
    private boolean clawIsOpen = false;
    // Map claw variables to driver hub
    public ClawCore (HardwareMap hardwareMap){
>>>>>>> ArcadeDrive-edits
        rightClaw = hardwareMap.get(Servo.class, "claw_right");
        leftClaw = hardwareMap.get(Servo.class, "claw_left");
    }


<<<<<<< HEAD
    /**
     * clawToggle
     * sets the claw to be in either open or closed position.
     * the state of the claw is stored as a private field within the object instance. This ensures
     * that the claw will still open and close even if it has been bumped or stressed to a different point.
=======
    /** clawToggle
     *  Sets the claw to be in either open or closed position.
     *  The state of the claw is stored as a private field within the object instance. This ensures
     *  that the claw will still open and close even if it has been bumped or stressed to a different point.
>>>>>>> ArcadeDrive-edits
     */
    public void clawToggle() {
        if (clawIsOpen) {
            clawClose();
        } else {
            clawOpen();
        }
    }

<<<<<<< HEAD
    /**
     * clawOpen
     * Opens the claw to a pre-set width.
=======

    /** clawOpen
     *  Opens the claw to a pre-set width, then updates clawIsOpen.
>>>>>>> ArcadeDrive-edits
     */
    public void clawOpen() {
        rightClaw.setPosition(0.575);
        leftClaw.setPosition(0.73);
        clawIsOpen = true;
    }

<<<<<<< HEAD
    /**
     * clawClose
     * closes the claw to a pre-set width.
=======
    /** clawClose
     *  Closes the claw to a pre-set width, then updates clawIsOpen.
>>>>>>> ArcadeDrive-edits
     */
    public void clawClose() {
        rightClaw.setPosition(0.67);
        leftClaw.setPosition(0.6);
        clawIsOpen = false;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Claw Right POS:", rightClaw.getPosition());
        telemetry.addData("Claw Left POS:", leftClaw.getPosition());
    }
}
