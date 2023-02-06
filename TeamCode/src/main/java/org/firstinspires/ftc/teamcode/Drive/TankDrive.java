package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawSlideManager;


/**
 * TankDrive
 * Tank drive. left stick controls left motor, right stick controls right motor.
 * See ClawSlideManager.java for information regarding the claw and slide.
 */
@TeleOp(name = "TankDrive", group = "auto")
public class TankDrive extends ClawSlideManager {
    @Override
    public void loop() {
        telemetry.addData("STATUS", "Running");
        telemetry.update();

        //// DRIVETRAIN
        // Move left/right wheels based on left/right stick movement
        double left = gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;
        drive.setPowers(left, right);
        drive.telemetry(telemetry, left, right);

        updateClaw(1);
        updateSlide(1);
    }
}
