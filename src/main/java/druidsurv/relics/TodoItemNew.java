package druidsurv.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import druidsurv.powers.bloons.BasicBloonPower;
import druidsurv.powers.bloons.DoubleBloonPower;
import druidsurv.util.ProAudio;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.playAudio;

public class TodoItemNew extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");
    private boolean inCombat = false;

    public TodoItemNew() {
        super(ID, RelicTier.BOSS, LandingSound.FLAT);
    }

    public void atBattleStartPreDraw() {
        this.counter = 3;
        this.inCombat = true;
    }

    public void onVictory() {
        this.inCombat = false;
    }

    public void onPlayerEndTurn() {
        counter++;
        AbstractPlayer p = AbstractDungeon.player;
        switch (counter)
        {
            case 4: flash(); ApplyBloonPowerActionToAll( 1, 14, 1, false, "Yellow Bloon"); break;
            case 6: flash(); ApplyBloonPowerActionToAll( 2, 25, 1, false, "Ceramic Bloon"); break;
            case 7: flash(); ApplyBloonPowerActionToAll( 4, 50, 1, false, "MOAB"); break;
            case 9: flash(); ApplyBloonPowerActionToAll( 4, 60, 1, false, "BFB"); break;
            case 11: flash(); ApplyBloonPowerActionToAll( 5, 80, 1, false, "ZOMG"); break;
            case 13: flash(); ApplyBloonPowerActionToAll( 5, 80, 1, false, "ZOMG"); ApplyBloonPowerActionToAll( 2, 25, 2, false, "Ceramic Bloon"); break;
            case 14: flash(); ApplyBloonPowerActionToAll( 3, 33, 2, true, "Double Rainbow Bloon"); break;
            case 16: flash(); ApplyBloonPowerActionToAll( 0, 10, 2, false, "Pink Bloon"); break;
            case 18: flash(); ApplyBloonPowerActionToAll( 5, 80, 2, false, "ZOMG"); break;
            case 20: flash(); ApplyBloonPowerActionToAll( 1, 11, 4, true, "Double Yellow Bloon"); break;
            case 22: flash(); ApplyBloonPowerActionToAll( 0, 10, 4, false, "Pink Bloon"); break;
            default: if (counter > 22 && counter % 2 == 0) { ApplyBloonPowerActionToAll( 3, 88, 4, true, "Double Ceramic Bloon"); break;}
        }
        if (counter == 12 || counter > 14 && counter % 2 == 1) { ApplyShacklesToAll(counter - 9);}
    }

    private void ApplyBloonPowerActionToAll(int delay, int amount, int times, boolean doubleBloon, String name)
    {
        playAudio(ProAudio.CardStorm01);
        AbstractPlayer p = AbstractDungeon.player;
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        for (int i = 0; i < times; i++) {
            playAudio(ProAudio.CardStormLightning01);
            if (doubleBloon) { addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new DoubleBloonPower(p, delay, amount, name), 1, true, AbstractGameAction.AttackEffect.NONE));}
            else { addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new BasicBloonPower(p, delay, amount, name), 1, true, AbstractGameAction.AttackEffect.NONE));}
        }

        for (int j = 0; j < temp; j++)
        {
            AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
            for (int i = 0; i < times; i++) {
                playAudio(ProAudio.CardStormLightning01);
                if (doubleBloon) { addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new DoubleBloonPower(m, delay, amount, name), 1, true, AbstractGameAction.AttackEffect.NONE));}
                else { addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, delay, amount, name), 1, true, AbstractGameAction.AttackEffect.NONE));}
            }
        }
    }

    private void ApplyShacklesToAll(int mult)
    {
        AbstractPlayer p = AbstractDungeon.player;
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        for (int i = 0; i < 1; i++) {
            playAudio(ProAudio.CardStormLightning01);
            this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, -1*mult), -1*mult));
            if (p != null && !p.hasPower("Artifact")) {
                this.addToBot(new ApplyPowerAction(p, p, new GainStrengthPower(p, mult), mult));
            }
        }
        for (int j = 0; j < temp; j++)
        {
            playAudio(ProAudio.CardStormLightning01);
            AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
            this.addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, -1*mult), -1*mult));
            if (m != null && !m.hasPower("Artifact")) {
                this.addToBot(new ApplyPowerAction(m, p, new GainStrengthPower(m, mult), mult));
            }
        }
    }

    public String getUpdatedDescription() {
    String description = this.DESCRIPTIONS[1];
    if (!inCombat) { return this.DESCRIPTIONS[0]; }

            int nextEffectRound = getNextEffectRound(counter);
            if (nextEffectRound > counter) {
                int delay = nextEffectRound - counter;
                description += this.DESCRIPTIONS[2] + delay + this.DESCRIPTIONS[3];
            }
            if (counter == 12 || (counter > 14 && counter % 2 == 1)) {
                description += this.DESCRIPTIONS[4] + getStrengthMultiplier(counter) + this.DESCRIPTIONS[6];
            } else {
                String effect = getEffect(counter);
                description += effect;
            }
            return description;
    }
    private int getNextEffectRound(int round) {
            // Calculate the round for the next effect based on current round
            // Ensure these match the trigger rounds in your main logic
            if (round < 4) return 4;
            if (round < 6) return 6;
            if (round < 7) return 7;
            if (round < 9) return 9;
            if (round < 11) return 11;
            if (round < 13) return 13;
            if (round < 14) return 14;
            if (round < 16) return 16;
            if (round < 18) return 18;
            if (round < 20) return 20;
            if (round < 22) return 22;
            return round + 2; // Default for rounds > 22
    }

    private int getStrengthMultiplier(int round) {
        return round - 9; // Example logic to calculate strength reduction multiplier
    }

        private String getEffect(int round) {
            switch (round) {
                case 4: return this.DESCRIPTIONS[7];
                case 6: return this.DESCRIPTIONS[8];
                case 7: return this.DESCRIPTIONS[9];
                case 9: return this.DESCRIPTIONS[10];
                case 11: return this.DESCRIPTIONS[11];
                case 13: return this.DESCRIPTIONS[12];
                case 14: return this.DESCRIPTIONS[13];
                case 16: return this.DESCRIPTIONS[14];
                case 18: return this.DESCRIPTIONS[15];
                case 20: return this.DESCRIPTIONS[16];
                case 22: return this.DESCRIPTIONS[17];
                default: return this.DESCRIPTIONS[18];
            }
        }


    /*switch (delay)
        {
            case 0: addToBot(new ApplyPowerAction(p, p, new zerodelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 1: addToBot(new ApplyPowerAction(p, p, new onedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 2: addToBot(new ApplyPowerAction(p, p, new twodelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 3: addToBot(new ApplyPowerAction(p, p, new threedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 4: addToBot(new ApplyPowerAction(p, p, new fourdelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 5: addToBot(new ApplyPowerAction(p, p, new fivedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            default: addToBot(new ApplyPowerAction(p, p, new onedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
        }*/
}


