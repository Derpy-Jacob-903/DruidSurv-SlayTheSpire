package druidsurv.relics;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import druidsurv.CharacterFile;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.oldBloons.*;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class TodoItemNewPro extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItemPro");
    private boolean activated;
    private int round;

    public TodoItemNewPro() {
        super(ID, RelicTier.BOSS, LandingSound.FLAT, CharacterFile.Enums.DRUIDSURV_COLOR);
    }
    private static final String starterReplaceID = TodoItem.ID;
    @Override
    public void obtain() {
        // Replace the starter relic, or just give the relic if starter isn't found
        if (AbstractDungeon.player.hasRelic(starterReplaceID)) {
            for (int i=0; i<AbstractDungeon.player.relics.size(); ++i) {
                if (AbstractDungeon.player.relics.get(i).relicId.equals(starterReplaceID)) {
                    instantObtain(AbstractDungeon.player, i, true);
                    break;
                }
            }
        } else {
            super.obtain();
        }
    }

    public boolean canSpawn() {
        return AbstractDungeon.player.hasRelic(makeID("TodoItem"));
    }

    public void atBattleStartPreDraw() {
        this.round = 0;
    }

    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.tags.contains(AbstractCard.CardTags.STRIKE) || c.tags.contains(CardTags.MONKEY))
        {
            AbstractPlayer p = AbstractDungeon.player;
            addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new DrawCardNextTurnPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    public void atTurnStartPostDraw() {
        round++;
        AbstractPlayer p = AbstractDungeon.player;
        switch (round)
        {
            case 4: flash(); ApplyBloonPowerActionToThem( 1, 14); break;
            case 5: flash(); ApplyBloonPowerActionToMe( 1, 14); break;
            case 6: flash(); ApplyBloonPowerActionToThem( 2, 25); break;
            case 7: flash(); ApplyBloonPowerActionToMe( 2, 25); ApplyBloonPowerActionToThem( 4, 50); break;
            case 8: flash(); ApplyBloonPowerActionToThem( 4, 50); break;
            case 9: flash(); ApplyBloonPowerActionToThem( 4, 60); break;
            case 10: flash(); ApplyBloonPowerActionToMe( 4, 60); break;
            case 11: flash(); ApplyBloonPowerActionToThem( 5, 80); break;
            case 12: flash(); ApplyBloonPowerActionToMe( 5, 80); break;
            case 13: flash(); ApplyBloonPowerActionToThem( 5, 80); ApplyBloonPowerActionToThem( 2, 50); break;
            case 14: flash(); ApplyBloonPowerActionToThem( 3, 70); ApplyBloonPowerActionToMe( 5, 80); ApplyBloonPowerActionToMe( 2, 50); break;
            case 15: flash(); ApplyBloonPowerActionToThem( 3, 70); break;
            case 16: flash(); ApplyBloonPowerActionToThem( 0, 20); break;
            case 17: flash(); ApplyBloonPowerActionToMe( 0, 20); break;
            case 18: flash(); ApplyBloonPowerActionToThem( 5, 160); break;
            case 19: flash(); ApplyBloonPowerActionToMe( 5, 160); break;
            case 20: flash(); ApplyBloonPowerActionToThem( 1, 88); break;
            case 21: flash(); ApplyBloonPowerActionToMe( 1, 88); break;
            case 22: flash(); ApplyBloonPowerActionToThem( 1, 88); break;
            case 23: flash(); ApplyBloonPowerActionToMe( 1, 88); break;
            default: if (round > 22) { if (round % 2 == 1) {ApplyBloonPowerActionToThem( 3, 88);} else {ApplyBloonPowerActionToMe( 3, 88);} break; }
        }
    }

    private void ApplyBloonPowerActionToThem(int delay, int amount)
    {
        AbstractPlayer p = AbstractDungeon.player;
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        for (int j = 0; j < temp; j++)
        {
            AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
            switch (delay)
            {
                case 0: addToBot(new ApplyPowerAction(m, p, new zerodelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
                case 1: addToBot(new ApplyPowerAction(m, p, new onedelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
                case 2: addToBot(new ApplyPowerAction(m, p, new twodelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
                case 3: addToBot(new ApplyPowerAction(m, p, new threedelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
                case 4: addToBot(new ApplyPowerAction(m, p, new fourdelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
                case 5: addToBot(new ApplyPowerAction(m, p, new fivedelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
                default: addToBot(new ApplyPowerAction(m, p, new onedelaybloon(m, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            }
        }
    }

    private void ApplyBloonPowerActionToMe(int delay, int amount)
    {
        AbstractPlayer p = AbstractDungeon.player;
        switch (delay)
        {
            case 0: addToBot(new ApplyPowerAction(p, p, new zerodelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 1: addToBot(new ApplyPowerAction(p, p, new onedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 2: addToBot(new ApplyPowerAction(p, p, new twodelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 3: addToBot(new ApplyPowerAction(p, p, new threedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 4: addToBot(new ApplyPowerAction(p, p, new fourdelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            case 5: addToBot(new ApplyPowerAction(p, p, new fivedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
            default: addToBot(new ApplyPowerAction(p, p, new onedelaybloon(p, amount), amount, true, AbstractGameAction.AttackEffect.LIGHTNING)); break;
        }
    }
}
