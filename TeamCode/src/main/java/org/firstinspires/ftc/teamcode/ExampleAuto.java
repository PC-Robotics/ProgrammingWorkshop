package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Example Auto")
public class ExampleAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor;
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        motor.setPower(0.5);
        sleep(200);
        motor.setPower(-0.5);
        sleep(200);
        motor.setPower(0.5);
        sleep(200);
        motor.setPower(-0.5);
        sleep(200);
    }
}
