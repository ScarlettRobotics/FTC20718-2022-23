package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawSlideManager;


/**
 * ClawSetter.java
 * Program used for finding specific claw servo positions.
 * The joystick controls are used to move the left/right servo, respectively.
 * This happens responsively, and the user can see the servo position through telemetry.
 * This currently does not work. */
@TeleOp(name = "ClawSetter", group = "auto")
public class ClawSetter extends ClawSlideManager {
    @Override
    public void loop() {
        telemetry.addData("STATUS: ", "Running");
        telemetry.update();

        claw.move(gamepad1.left_stick_x/500.0, gamepad1.right_stick_x/500.0);
        claw.telemetry(telemetry);
    }

}
