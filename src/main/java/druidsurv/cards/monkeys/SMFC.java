package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.ThornPower;
import druidsurv.powers.WizardPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.p;

public class SMFC extends AbstractEasyCard {
    public final static String ID = makeID("SMFC");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SMFC() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "SuperMonkeyFanClub");
        baseDamage = 6;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new StrengthPower(p(), 2), 2, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new ThornPower(p(), -2), -2, true, AbstractGameAction.AttackEffect.NONE));
        //addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new WizardPower(p(), -2), -2, true, AbstractGameAction.AttackEffect.NONE));
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}