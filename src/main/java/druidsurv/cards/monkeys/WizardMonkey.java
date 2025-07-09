package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.WizardPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.p;

public class WizardMonkey extends AbstractEasyCard {
    public final static String ID = makeID("WizardMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public WizardMonkey() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "MonkeyApprentice_CardArt");
        baseDamage = 5;
        damage = 4;
        baseMagicNumber = 1;
        magicNumber = baseMagicNumber;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        tags.add(druidsurv.cards.cardvars.CardTags.WIZARD);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //damage +=
        //int prizedCount = (int)(Math.sqrt(bone)+2);
        //addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Prized(p, prizedCount), prizedCount, true, AbstractGameAction.AttackEffect.NONE));
        atb(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.LIGHTNING));
    }

    public void atTurnStart() {
        //baseDamage++;
        addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new WizardPower(p(), magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}