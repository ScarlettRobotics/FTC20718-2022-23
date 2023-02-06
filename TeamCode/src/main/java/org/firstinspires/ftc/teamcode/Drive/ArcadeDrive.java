package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.ClawSlideManager;


/**
 * ArcadeDrive
 * Arcade driving, similar to playing a racing game.
 * See ClawSlideManager.java for information regarding the claw and slide.
 */

@TeleOp(name = "ArcadeDrive", group = "auto")
public class ArcadeDrive extends ClawSlideManager {
    public
    @Override void loop() { //START - after start button is pushed
        telemetry.addData("STATUS: ", "Running");
        telemetry.update();

        //// DRIVETRAIN
        // Move drivetrain based on left stick movement
        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        drive.setPowers(forward + right, -1 * (forward - right) );
        // Debug info
        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);

        updateClaw(1);
        updateSlide(1);
    }
}
