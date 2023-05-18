package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Core.SystemsManager;


/**
 * ArcadeDrive 2 Player
 * Designed for driving to be on controller 1, upper systems on controller 2.
 * Arcade drive. left stick controls turning (left/right), right stick controls forward/backward movement.
 * See ClawSlideManager.java for information regarding the claw and slide.
 */
@TeleOp(name = "ArcadeDrive2P", group = "auto")
public class ArcadeDrive2p extends SystemsManager {
    @Override
    public void loop() {
        telemetry.addData("STATUS: ", "Running");
        updateClaw(2);
        updateSlide(2);
        updateMotorArcade(1);
    }
}
