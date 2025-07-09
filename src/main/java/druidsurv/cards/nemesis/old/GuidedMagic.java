package druidsurv.cards.nemesis.old;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DarkOrbEvokeAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.NemCharacterFile;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

@AutoAdd.Ignore
@Deprecated
public class GuidedMagic extends AbstractEasyCard {
    public final static String ID = makeID("GuidedMagic");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public GuidedMagic() {
        super(ID, 1, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "MonkeyApprentice_CardArt");
        baseDamage = 5;
        damage = baseDamage;
        baseMagicNumber = 1;
        magicNumber = baseMagicNumber;
        tags.add(druidsurv.cards.cardvars.CardTags.WIZARD);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //damage +=
        //int prizedCount = (int)(Math.sqrt(bone)+2);
        //addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Prized(p, prizedCount), prizedCount, true, AbstractGameAction.AttackEffect.NONE));
        atb(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.LIGHTNING));
        atb(new DarkOrbEvokeAction(new DamageInfo(p, Math.max(damage - 2, baseDamage - 3), damageTypeForTurn), AbstractGameAction.AttackEffect.LIGHTNING));
    }

    public void atTurnStart() {
        //baseDamage++;
        //addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), (AbstractPower)new WizardPower(p(), magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}