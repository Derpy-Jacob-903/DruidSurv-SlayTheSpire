package druidsurv.util;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.bloons.BaseBloon;
import druidsurv.powers.oldBloons.*;

import java.util.ArrayList;
import java.util.Arrays;

import static druidsurv.util.Wiz.atb;

public class CascadeHandler {

    public ArrayList<BaseBloon> myBloons = null;

    /**
     * cascade Class.
     *
     * Deals damage to 'owner' based on how much 'zerodelaybloon' it has, and removes it's 'zerodelaybloon',
     * then adds 'zerodelaybloon' based on how much 'onedelaybloon' it has and remove it's 'onedelaybloon',
     * then adds 'onedelaybloon' based on how much 'twodelaybloon' it has and remove it's 'twodelaybloon',
     * etc...
     */
    @Deprecated
    public void cascade(AbstractCreature owner) {

    }

    @Deprecated
    public void cascadeOld(AbstractCreature owner) {
        if (owner == null) {
            System.err.println("Owner is null");
            return; // Early exit if owner is null
        }

        int[] s = getPowersAmount(owner);

        //logState("Initial state", s, z);

        boolean converted = false;

        applyDamage(owner, s[0]);
        removePower(owner, zerodelaybloon.POWER_ID);
        //logState("After Damage", s, z);

        //removePower(owner, zerodelaybloon.POWER_ID);
        applyPower(owner, new zerodelaybloon(owner, getPowerAmount(owner, onedelaybloon.POWER_ID)), getPowerAmount(owner, onedelaybloon.POWER_ID));
        removePower(owner, onedelaybloon.POWER_ID);

        applyPower(owner, new onedelaybloon(owner, getPowerAmount(owner, twodelaybloon.POWER_ID)), getPowerAmount(owner, twodelaybloon.POWER_ID));
        removePower(owner, twodelaybloon.POWER_ID);

        applyPower(owner, new twodelaybloon(owner, getPowerAmount(owner, threedelaybloon.POWER_ID)), getPowerAmount(owner, threedelaybloon.POWER_ID));
        removePower(owner, threedelaybloon.POWER_ID);

        applyPower(owner, new threedelaybloon(owner, getPowerAmount(owner, fourdelaybloon.POWER_ID)), getPowerAmount(owner, fourdelaybloon.POWER_ID));
        removePower(owner, fourdelaybloon.POWER_ID);

        applyPower(owner, new fourdelaybloon(owner, getPowerAmount(owner, fivedelaybloon.POWER_ID)), getPowerAmount(owner, fivedelaybloon.POWER_ID));
        removePower(owner, fivedelaybloon.POWER_ID);

    }

    /**
     * fortify Class.
     *
     * Adds 'amount' of the lowest delay bloon to 'owner',
     * zerodelaybloon > onedelaybloon > twodelaybloon etc...
     */
    public void fortify(AbstractCreature owner, int amount) {
        getBloons(owner);
        if (myBloons == null) { return; }
        BaseBloon witch = myBloons.get(0);
        int balls = 0;
        for (int i = 1; i < myBloons.size(); i++) {
            if (witch.amount2 == 0) { //a zero delay bloon is always the best choice for fortify
                break;
            }
            if (witch.amount2 < myBloons.get(i).amount2) {
                balls = i;
            }
        }
        myBloons.get(balls).amount2 += 12;
    }

    @Deprecated
    public void fortifyOld(AbstractCreature owner, int amount) {
        if (owner == null) {
            System.err.println("Owner is null");
            return; // Early exit if owner is null
        }
        if (owner.hasPower(zerodelaybloon.POWER_ID)) {
            applyPower(owner, new zerodelaybloon(owner, amount), amount);
        }
        else if (owner.hasPower(onedelaybloon.POWER_ID)) {
            applyPower(owner, new onedelaybloon(owner, amount), amount);
        }
        else if (owner.hasPower(twodelaybloon.POWER_ID)) {
            applyPower(owner, new twodelaybloon(owner, amount), amount);
        }
        else if (owner.hasPower(threedelaybloon.POWER_ID)) {
            applyPower(owner, new threedelaybloon(owner, amount), amount);
        }
        else if (owner.hasPower(fourdelaybloon.POWER_ID)) {
            applyPower(owner, new fourdelaybloon(owner, amount), amount);
        }
        else if (owner.hasPower(fivedelaybloon.POWER_ID)) {
            applyPower(owner, new fivedelaybloon(owner, amount), amount);
        }
    }

    /**
     * improvedFortify Class.
     *
     * Adds 'amount' of the lowest amount bloon to 'owner',
     * zerodelaybloon has it's count doubled.
     */
    public void improvedFortify(AbstractCreature owner, int amount) {
        getBloons(owner);
        if (myBloons == null) { return; }
        BaseBloon witch = myBloons.get(0);
        int balls = 0;

        for (int i = 1; i < myBloons.size(); i++) {
            if (witch.amount2 < myBloons.get(i).amount2) {
                balls = i;
            }
        }
        myBloons.get(balls).amount += 1;
        myBloons.get(balls).amount2 += 36;

        /*if (owner == null) {
            System.err.println("Owner is null");
            return; // Early exit if owner is null
        }
        int[] s = getPowersAmount(owner);
        boolean converted = false;

        ArrayList<Integer> witch = new ArrayList<>(Arrays.asList(0, s[0]*2));
        for (int i = 1; i < s.length; i++) {
            if (witch.get(1) < s[i]) {
                witch.set(0, i);
                witch.set(1, s[i]);
            }
        }

        switch (witch.get(0))
        {
            case 0: applyPower(owner, new zerodelaybloon(owner, amount), amount); break;
            case 1: applyPower(owner, new onedelaybloon(owner, amount), amount); break;
            case 2: applyPower(owner, new twodelaybloon(owner, amount), amount); break;
            case 3: applyPower(owner, new threedelaybloon(owner, amount), amount); break;
            case 4: applyPower(owner, new fourdelaybloon(owner, amount), amount); break;
            case 5: // |
            case 6: // V
            case 7: applyPower(owner, new fivedelaybloon(owner, amount), amount); break;
            default:  break;
        }*/
    }
    /**
     * embiggen Class.
     *
     * Adds 'amount' to all '-delaybloon' powers 'owner' has.
     */
    public void embiggen(AbstractCreature owner, int amount) {
        getBloons(owner);
        if (myBloons == null) { return; }
        for (int i = 1; i < myBloons.size(); i++) {
            myBloons.get(i).amount2 += 6;
        }
    }
    /**
     * embiggen Class.
     *
     * Adds 'amount' to all '-delaybloon' powers 'owner' has.
     */
    @Deprecated
    public void embiggenOld(AbstractCreature owner, int amount) {
        if (owner == null) {
            System.err.println("Owner is null");
            return; // Early exit if owner is null
        }
        if (owner.hasPower(zerodelaybloon.POWER_ID)) {
            applyPower(owner, new zerodelaybloon(owner, amount), amount);
        }
        if (owner.hasPower(onedelaybloon.POWER_ID)) {
            applyPower(owner, new onedelaybloon(owner, amount), amount);
        }
        if (owner.hasPower(twodelaybloon.POWER_ID)) {
            applyPower(owner, new twodelaybloon(owner, amount), amount);
        }
        if (owner.hasPower(threedelaybloon.POWER_ID)) {
            applyPower(owner, new threedelaybloon(owner, amount), amount);
        }
        if (owner.hasPower(fourdelaybloon.POWER_ID)) {
            applyPower(owner, new fourdelaybloon(owner, amount), amount);
        }
        if (owner.hasPower(fivedelaybloon.POWER_ID)) {
            applyPower(owner, new fivedelaybloon(owner, amount), amount);
        }
    }

    private void applyDamage(AbstractCreature owner, int amount) {
        if (amount > 0) {
            //System.out.println("Applying Damage: " + amount);
            if (amount > 74.5) {
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
            }
            else {
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            }
        }
    }

    private void removePower(AbstractCreature owner, String powerId) {
        if (owner.hasPower(powerId)) {
            AbstractPower power = owner.getPower(powerId);
            if (power != null) {
                //System.out.println("Removing Power: " + powerId);
                atb(new RemoveSpecificPowerAction(owner, owner, power));
            }
        }
    }

    private void applyPower(AbstractCreature owner, AbstractPower power, int amount) {
        if (amount > 0) {
            //System.out.println("Applying Power: " + power.ID + " with amount " + amount);
            atb(new ApplyPowerAction(owner, owner, power, amount, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    //private void logState(String stage, int[] s, int[] z) {
        //System.out.println(stage + ": s = " + Arrays.toString(s) + " z = " + Arrays.toString(z));
    //}

    private int getPowerAmount(AbstractCreature owner, String powerId) {
        if (owner == null) {
            //System.err.println("getPowerAmount: Owner is null");
            return 0;
        }
        AbstractPower power = owner.getPower(powerId);
        if (power == null) {
            //System.err.println("getPowerAmount: Power " + powerId + " is null");
            return 0;
        }
        return power.amount;
    }

    private int[] getPowersAmount(AbstractCreature owner) {
        return new int[] {
                getPowerAmount(owner, zerodelaybloon.POWER_ID),
                getPowerAmount(owner, onedelaybloon.POWER_ID),
                getPowerAmount(owner, twodelaybloon.POWER_ID),
                getPowerAmount(owner, threedelaybloon.POWER_ID),
                getPowerAmount(owner, fourdelaybloon.POWER_ID),
                getPowerAmount(owner, fivedelaybloon.POWER_ID)
        };
    }



    private ArrayList<BaseBloon> getBloons(AbstractCreature owner) {
        ArrayList<BaseBloon> myBloonsTmp = new ArrayList<BaseBloon>();
        for (int i = 0; i < owner.powers.size(); i++) {
            if (owner.powers.get(i) instanceof BaseBloon) {myBloonsTmp.add((BaseBloon)owner.powers.get(i));
            }
        }
        myBloons = myBloonsTmp;
        if (myBloonsTmp.isEmpty()) { myBloons = null; myBloonsTmp = null;} //null = no bloons
        return myBloonsTmp;
    }

    private int[] update(AbstractCreature owner) {
        return getPowersAmount(owner);
    }
}
