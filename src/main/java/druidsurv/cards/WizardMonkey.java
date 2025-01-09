package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.Prized;
import druidsurv.powers.WizardPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.p;

public class WizardMonkey extends AbstractEasyCard {
    public final static String ID = makeID("WizardMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public WizardMonkey() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 5;
        magicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Prized(p, 6), 6, true, AbstractGameAction.AttackEffect.NONE));
        int bone = 0;
        if (p.hasPower(WizardPower.POWER_ID)){ bone = p.getPower(WizardPower.POWER_ID).amount;}
        atb(new DamageAction(m, new DamageInfo(p, damage + bone, damageTypeForTurn), AbstractGameAction.AttackEffect.LIGHTNING));
    }

    public void atTurnStart() {

        addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new WizardPower(p(), damage), damage, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}